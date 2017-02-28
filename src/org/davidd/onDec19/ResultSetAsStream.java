package org.davidd.onDec19;

import org.junit.Test;

import java.sql.*;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by David on 12/19/2016.
 */
public class ResultSetAsStream {

    @Test
    public void clientCodeJava7() throws Exception {

        try (Stream<String> stream = getBrands()) {
            stream.forEach(System.out::print);
        }
    }

    @Test
    public void clientCodeJava6() throws Exception {
        Stream<String> stream = null;
        try {
            stream = getBrands();
            stream.forEach(System.out::print);
        } finally {
            stream.close();
        }
    }

    public Stream<String> getBrands() throws SQLException {
        String url = "";
        String username = "";
        String password = "";

        Connection connection = DriverManager.getConnection(url, username, password);

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Car");
        final ResultSet resultSet = statement.executeQuery();

        Spliterator<String> spliterator = Spliterators.spliteratorUnknownSize(new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return safeExecute(resultSet::next);
            }

            @Override
            public String next() {
                return safeExecute(() -> resultSet.getString("brand"));
            }
        }, Spliterator.CONCURRENT);

        Stream<String> theStream = StreamSupport.stream(spliterator, true);

        theStream.onClose(new Runnable() {
            @Override
            public void run() {
                closeResource(statement);
                closeResource(resultSet);
                closeResource(connection);
            }
        });

        return theStream;
    }

    private static void closeResource(AutoCloseable autoCloseable) {
//        safeExecute(() -> autoCloseable.close());
    }

    @FunctionalInterface
    interface UnsafeSupplier<T> extends Supplier<T> {

        default T get() {
            try {
                return getWithException();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        T getWithException() throws Exception;
    }

    public static <T> T safeExecute(UnsafeSupplier<T> s) {
        return s.get();
    }
}

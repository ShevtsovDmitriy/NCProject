package DBConnection;

import java.sql.ResultSet;

/**
 * Created by Дмитрий on 06.02.2015.
 * Интерфейс для ResultSetHandler`а, который преобразует ResultSet в удобоваримое представление
 */
public interface ResultSetHandler<T> {

    public T handle(ResultSet rs);

}

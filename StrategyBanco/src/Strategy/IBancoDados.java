package Strategy;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public interface IBancoDados {

    public void Instancia();
    public void Execute(String sql);
    public ResultSet Select(String sql);

}


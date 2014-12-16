package blasta.cleveroad.system.queries;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import blasta.cleveroad.system.model.ImageModel;

/**
 * Created by 1 on 15.12.2014.
 */
public class QuerySearch implements Query{
    private final String query;

    public QuerySearch(String query){
        this.query = query;
    }


    @Override
    public List<ImageModel> fromPage(int start) throws IOException, JSONException {

        SearchCo

    }
}

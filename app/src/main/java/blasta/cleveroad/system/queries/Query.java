package blasta.cleveroad.system.queries;

import java.util.List;

import blasta.cleveroad.system.model.ImageModel;

/**
 * Created by 1 on 15.12.2014.
 */
public interface Query {

    public List<ImageModel> fromPage(int start) throws Exception;

}

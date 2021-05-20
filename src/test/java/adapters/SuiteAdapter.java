package adapters;

import models.Suite;

public class SuiteAdapter extends BaseAdapter {
    public static final String URI = "v1/suite";

    public void post(Suite suite, String projectName) {
        String resp = post(gson.toJson(suite), URI + "/" + projectName, 200);
        checkStatus(resp);
    }
}

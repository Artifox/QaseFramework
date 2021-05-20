package adapters;

import models.Project;

public class ProjectAdapter extends BaseAdapter {
    public static final String URI = "v1/project";

    public void post(Project project) {
        String response = post(gson.toJson(project), URI, 200);
        checkStatus(response);
    }

    public void get(String projectCode) {
        String response = get(URI + "/" + projectCode, 200);
        checkStatus(response);
    }

}

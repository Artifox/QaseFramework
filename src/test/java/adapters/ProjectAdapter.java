package adapters;

import models.Project;

public class ProjectAdapter extends BaseAdapter {
    public static final String URI = "v1/project";

    public void post(Project project, boolean expectedResult) {
        String response = post(gson.toJson(project), URI, 200);
        checkStatus(response, expectedResult);
    }

    public void get(Project project, int status, boolean expectedResult) {
        String response = get(URI + "/" + project.getCode(), status);
        checkStatus(response, expectedResult);
    }


    public void delete(String projectCode, boolean expectedResult) {
        String response = delete(URI + "/" + projectCode, 200);
        checkStatus(response, expectedResult);
    }

}

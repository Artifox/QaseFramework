package adapters;

import io.qameta.allure.Step;
import models.Project;

public class ProjectAdapter extends BaseAdapter {
    public static final String URI = "v1/project";

    @Step("Create a new project: {project.title}")
    public void post(Project project, boolean expectedResult) {
        String response = post(gson.toJson(project), URI, 200);
        checkStatus(response, expectedResult);
    }

    @Step("Get project: {project.title}")
    public void get(Project project, int status, boolean expectedResult) {
        String response = get(URI + "/" + project.getCode(), status);
        checkStatus(response, expectedResult);
    }

    @Step("Delete project: {project.title}")
    public void delete(Project project, boolean expectedResult) {
        String response = delete(URI + "/" + project.getCode(), 200);
        checkStatus(response, expectedResult);
    }

}

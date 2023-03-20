package models;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.management.loading.PrivateClassLoader;
import javax.management.relation.Role;

public class ModelRoles {
	
	private static ModelRoles instance = new ModelRoles();
	
	private List<Role> modelRole;

	public static ModelRoles getInstance() {
        return instance;
    }
	
	private ModelRoles() {
		modelRole = new ArrayList<>();
    }
	
	public void addRole(Role role) {
        modelRole.add(role);
    }
	
	public List<String> list() {
        return modelRole.stream()
                .map(Role::getRoleName)
                .collect(Collectors.toList());
    }

}

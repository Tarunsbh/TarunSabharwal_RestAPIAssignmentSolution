package com.employeemanagement.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.app.model.Role;
import com.employeemanagement.app.repository.RoleRepository;


@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public Role getRoleById(Integer roleId) {
		Optional<Role> roleOptional = roleRepository.findById(roleId);
		if(roleOptional.isPresent()) {
			return roleOptional.get();
			}
			return null;
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Role editRoleById(Integer roleId, String name) {
		Role role = getRoleById(roleId);
		role.setName(name);
		return roleRepository.save(role);
	}

	@Override
	public void deleteRoleById(Integer roleId) {
		Role role = getRoleById(roleId);
		roleRepository.delete(role);
	}

}

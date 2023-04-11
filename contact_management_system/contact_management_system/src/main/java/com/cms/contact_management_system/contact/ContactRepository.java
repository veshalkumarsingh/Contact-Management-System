package com.cms.contact_management_system.contact;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
	public List<Contact> findByUsername(String username);
}

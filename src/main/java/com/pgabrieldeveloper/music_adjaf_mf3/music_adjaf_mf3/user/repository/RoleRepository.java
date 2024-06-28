package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.repository;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.repository.Entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
}

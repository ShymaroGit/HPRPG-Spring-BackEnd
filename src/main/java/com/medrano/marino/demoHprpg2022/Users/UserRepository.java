package com.medrano.marino.demoHprpg2022.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    @Query("SELECT username as username,custom_dark_color as custom_dark_color,custom_light_color as custom_light_color,use_custom_color as user_custom_color,uuid as uuid, privilege as privilege FROM Users")
    List<IUserSafe> getUsers();

    @Query("SELECT username as username,custom_dark_color as custom_dark_color,custom_light_color as custom_light_color,use_custom_color as user_custom_color,uuid as uuid, privilege as privilege FROM Users WHERE username = ?1")
    Optional<IUserSafe> getUserByUsername(String username);

    @Query("SELECT new Users(username,privilege,use_custom_color,custom_dark_color,custom_light_color,uuid,password) FROM Users WHERE uuid = ?1")
    Optional<Users> getUserByUUIDFull(String uuid);

    @Query("SELECT username as username,custom_dark_color as custom_dark_color,custom_light_color as custom_light_color,use_custom_color as user_custom_color,uuid as uuid, privilege as privilege FROM Users WHERE uuid = ?1")
    Optional<IUserSafe> getUserByUUIDSafe(String uuid);
    @Query("SELECT new Users(username,privilege,use_custom_color,custom_dark_color,custom_light_color,uuid,password) FROM Users WHERE username = ?1")
    Optional<Users> Login(String username);

    @Transactional
    @Modifying
    @Query("UPDATE Users SET password = ?2 WHERE uuid = ?1")
    void updatePassword(String uuid, String newPassword);
}

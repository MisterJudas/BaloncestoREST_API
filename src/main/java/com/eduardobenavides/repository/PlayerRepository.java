package com.eduardobenavides.repository;

import com.eduardobenavides.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Created by Amilcar on 10/10/2016.
 */

public interface PlayerRepository extends JpaRepository<Player,Long>{

    //Spring Data Queries

    List<Player> findByName(String name);

    List<Player> findByPointsGreaterThanEqual(Integer points);

    List<Player> findByPointsBetween(Integer min, Integer max);

    List<Player> findByPointsGreaterThan(Integer points);

    List<Player> findByPoints(Integer points);

    // JPL Queries
/*
    @Query("SELECT player.position,AVG(player.points),AVG(player.rebounds),AVG(player.assists) from Player player GROUP BY player.position")
    List<Object[]> AvgPointsReboundsAssistsPerPosition();

    @Query("SELECT player.position,AVG(player.points),MAX(player.points),MIN(player.points),AVG(player.rebounds),MAX(player.rebounds),MIN(player.rebounds),AVG(player.assists),MAX(player.assists),MIN(player.assists) FROM Player player GROUP BY player.position")
    List<Object[]> AvgMaxMinPointsReboundsAssistsPerPosition();

    @Query("SELECT player FROM Player player WHERE player.team = :team")
    List<Player> findPlayerByTeam(@Param("team") Team team);

    @Query("SELECT player from Player player WHERE player.team = :team AND player.position = :position")
    List<Player> findPlayerPositionByTeam(@Param("team") Team team, @Param("position") String position);

    @Query("SELECT player from Player player WHERE player.team = :team AND player.points IN (SELECT MAX(player.points) FROM Player player WHERE player.team = :team)")
    List<Player> findMaxPointsPlayerByTeam(@Param("team") Team team);

*/

}

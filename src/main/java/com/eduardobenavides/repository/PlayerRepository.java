package com.eduardobenavides.repository;

import com.eduardobenavides.domain.Player;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Amilcar on 10/10/2016.
 */

public interface PlayerRepository extends JpaRepository<Player,Long>{

    //Spring Data Queries

    List<Player> findByName(String name);
    List<Player> findByPointsGreaterThanEqual(Integer points);
    List<Player> findByPoints(Integer points);


    //1 ORDENAR POR NUMERO CANASTAS
    List<Player> findByOrderByPointsDesc();

    //2 CANASTAS IGUAL O SUPERIOR A URL
    List<Player> findByPointsGreaterThan(Integer points);

    //3 CANASTAS ENTRE X/X PUNTOS
    List<Player> findByPointsBetween(Integer min, Integer max);

    //4 JUGADORES AGRUPADOS POR POSICION
    List<Player> findByPositionEquals(String position);

    //5 JUGADORES POR POSICION MOSTRANDO ESTADISTICAS


   /* @Query("SELECT player.position,AVG(player.points),MAX(player.points),MIN(player.points),AVG(player.rebounds),MAX(player.rebounds),MIN(player.rebounds),AVG(player.assists),MAX(player.assists),MIN(player.assists) FROM Player player GROUP BY player.position")
    List<Object[]> AvgMaxMinPointsReboundsAssistsPerPosition();*/



}

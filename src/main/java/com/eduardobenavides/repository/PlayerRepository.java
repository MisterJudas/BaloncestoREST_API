package com.eduardobenavides.repository;

import com.eduardobenavides.domain.Player;
import com.eduardobenavides.domain.Position;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Amilcar on 10/10/2016.
 */

public interface PlayerRepository extends JpaRepository<Player,Long>{

    //Spring Data Queries

    List<Player> findByName(String name);

    // a. Buscar jugadores por nombre, de manera que no sea necesario introducir el nombre completo.
    List<Player> findByNameStartingWith(String name);

    // b. Buscar jugadores que hayan conseguido un número mayor o igual a un número de canastas especificado como parámetro.
    List<Player> findByPointsGreaterThanEqual  (int points);

    //c. Buscar jugadores que hayan efectuado un número de asistencias dentro de un rango especificado como parámetro.
    List<Player> findByAssistsBetween(int min, int max);

    // d. Buscar jugadores que pertenezcan a una posición específica, por ejemplo: base.
    List<Player> findByPositionEquals(Position position);

    // e. Buscar jugadores que hayan nacido en una fecha anterior a una fecha especificada como parámetro.
    List<Player> findByBirthDateAfter(LocalDate birth);

    // f. Agrupar los jugadores por la posición del campo y devolver para cada grupo la siguiente información: la media de canastas, asistencias y rebotes.
    @Query("select avg(p.points), avg(p.assists), avg(p.rebound), p.position from Player p group by p.position")
    List<Object[]> findAvgOfPointsAssistsReboundByPosition ();

    // g. Lo mismo que el punto anterior pero devolviendo la media, el máximo y el mínimo de canastas, asistencias y rebotes.
    @Query("select p.position, avg(p.points), max(p.points), min(p.points), avg(p.assists), max(p.assists), min(p.assists), avg(p.rebound), max(p.rebound), min(p.rebound) from Player p group by p.position")
    List<Object[]> findAvgMinMaxOfPointsAssistsReboundByPosition ();


    //1 ORDENAR POR NUMERO CANASTAS
    List<Player> findByOrderByPointsDesc();

    //2 CANASTAS IGUAL O SUPERIOR A URL
    List<Player> findByPointsGreaterThan(Integer points);

    //3 CANASTAS ENTRE X/X PUNTOS
    List<Player> findByPointsBetween(Integer min, Integer max);

    //4 JUGADORES AGRUPADOS POR POSICION
    @Query("select p.position, min(p.points), max(p.points), avg(p.points) from Player p group by p.position")
    List<Object[]> groupByPosition();

    //5 JUGADORES POR POSICION MOSTRANDO ESTADISTICAS
    @Query("select p from Player p order by p.points")
    List<Player> playersByPositionPoints();



}

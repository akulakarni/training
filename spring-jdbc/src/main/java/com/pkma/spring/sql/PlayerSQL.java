/**
 * 
 */
package com.pkma.spring.sql;

public class PlayerSQL {

    public static final String GET_ALL_PLAYERS = getAllPlayersSelectSql();
    public static final String GET_PLAYER = getPlayerSelectSql();
    public static final String CREATE_PLAYER = playerInsertSql();
    public static final String UPDATE_PLAYER = playerUpdateSql();
    public static final String DELETE_PLAYER = playerDeleteSql();

    private static String getAllPlayersSelectSql() {
        final StringBuilder sql = new StringBuilder();
        sql.append("select * from player");
        return sql.toString();
    }

    private static String playerDeleteSql() {
        final StringBuilder sql = new StringBuilder();
        sql.append("delete from player\n");
        sql.append("where player_id = :player_id");
        return sql.toString();
    }

    private static String playerUpdateSql() {
        final StringBuilder sql = new StringBuilder();
        sql.append("update player set \n");
        sql.append("name = :name,\n");
        sql.append("age = :age,\n");
        sql.append("club = :club,\n");
        sql.append("position = :position,\n");
        sql.append("country = :country,\n");
        sql.append("jersey_nbr = :jersey_nbr,\n");
        sql.append("goals = :goals,\n");
        sql.append("assists = :assists\n");
        sql.append("where player_id = :player_id");
        return sql.toString();
    }

    private static String playerInsertSql() {
        final StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO player (\n");
        sql.append("player_id,\n");
        sql.append("name,\n");
        sql.append("age,\n");
        sql.append("club,\n");
        sql.append("position,\n");
        sql.append("country,\n");
        sql.append("jersey_nbr,\n");
        sql.append("goals,\n");
        sql.append("assists )\n");
        sql.append("VALUES (player_Q1.nextval, :name, :age, :club, :position, :country, :jersey_nbr, :goals, :assists)");
        return sql.toString();
    }
    private static String getPlayerSelectSql() {
        final StringBuilder sql = new StringBuilder();
        sql.append("select * from player\n");
        sql.append("where player_id = :player_id");
        return sql.toString();
    }
}

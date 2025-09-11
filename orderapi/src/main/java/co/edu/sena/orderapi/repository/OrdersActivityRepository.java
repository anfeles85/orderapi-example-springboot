/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.orderapi.repository;

import co.edu.sena.orderapi.model.OrdersActivity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sena
 */
@Repository
public interface OrdersActivityRepository extends JpaRepository<OrdersActivity, Long>{
    //consultar las ordenes de una actividad especifica
    @Query("SELECT o FROM OrdersActivity o WHERE o.activityId.id = :activityId")
    List<OrdersActivity> findByActivityId(@Param("activityId") long activityId);
    
    //consultar las actividades de una orden especifica
    @Query("SELECT o FROM OrdersActivity o WHERE o.ordersId.id = :ordersId")
    List<OrdersActivity> findByOrdersId(@Param("ordersId") long ordersId);
}

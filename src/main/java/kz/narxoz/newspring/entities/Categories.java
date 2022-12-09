package kz.narxoz.newspring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.dialect.function.StandardAnsiSqlAggregationFunctions;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categories {


  @Id
  @GeneratedValue(strategy =GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name="name", length = 200)
  private String name;


}


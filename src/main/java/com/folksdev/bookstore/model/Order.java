package com.folksdev.bookstore.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table
@Data
@Getter
@Setter
@Builder
@Entity(name ="BookOrder")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String username;
  @Column
  @ElementCollection(targetClass=Integer.class)
  private List<Integer> bookList;
  private double totalPrice;

}

package net.codejava;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "title", nullable = false, length = 20)
	private String title;
	
	@Column(name = "body", nullable = false, length = 50)
	private String body;
	
	@CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createTime;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updateTime;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;
}

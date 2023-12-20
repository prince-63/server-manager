package com.learn.model;

import com.learn.enumeration.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "server_tb",
        uniqueConstraints = {
                @UniqueConstraint(
                        name="ip_address_unique",
                        columnNames = "ip_address"
                )
        }
)
public class Server {
    @Id
    @SequenceGenerator(
            name="server_sequence",
            sequenceName = "server_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "server_sequence"
    )
    private Long id;
    @Column(
            name = "ip_address"
    )
    @NotEmpty(message = "IP Address cannot be empty or null")
    private String ipAddress;
    @Column(
            name="server_name"
    )
    private String name;
    private String memory;
    private String type;
    private String imageURL;
    private Status status;
}

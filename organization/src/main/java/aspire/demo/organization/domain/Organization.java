package aspire.demo.organization.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Organization {

    @Id
    private String organizationId;

    @Column
    private String name;

    @Column
    private String contactName;

    @Column
    private String contactEmail;

    @Column
    private String contactPhone;
}

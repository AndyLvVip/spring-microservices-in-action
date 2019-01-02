package aspire.demo.licensing.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "license")
@Data
public class License {

    @Id
    @Column
    private String licenseId;

    @Column
    private String organizationId;

    @Column
    private String productName;

    @Column
    private String licenseType;

    @Column
    private Integer licenseMax;

    @Column
    private Integer licenseAllocated;

    @Column
    private String comment;

    transient Organization organization;

}

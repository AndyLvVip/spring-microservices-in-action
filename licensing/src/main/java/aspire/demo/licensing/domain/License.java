package aspire.demo.licensing.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "license")
public class License {

    @Id
    @Column
    private String licenseId;

    @Column
    private String organizationId;

    @Column
    private String productName;

}

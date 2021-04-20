package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="MissionExterne")
public class MissionExterne extends Mission implements Serializable {

	private static final long serialVersionUID = 1L;
//	@Id
//	@GeneratedValue (strategy = GenerationType.IDENTITY)
//	@Column(name="MISSION_ID")
//	private long id;
	@Column(name="MISSION_EXTERNE_EMAIL_FACTURATION")
	private String email_facturation;
	@Column(name="MISSION_EXTERNE_TAUX_JOURNALIER_MOYEN")
	private float taux_journalier_moyen;
}

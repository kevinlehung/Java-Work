package vn.jv.persist.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_question database table.
 * 
 */
@Entity
@Table(name="t_question")
@NamedQuery(name="TQuestion.findAll", query="SELECT t FROM TQuestion t")
public class TQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="QUESTION_ID")
	private int questionId;

	private int duration;

	@Column(name="IS_MULTIPLE_CHOICE")
	private boolean isMultipleChoice;

	private String stem;

	//bi-directional many-to-one association to TOption
	@OneToMany(mappedBy="tQuestion")
	private List<TOption> tOptions;

	//bi-directional many-to-one association to Skill
	@ManyToOne
	@JoinColumn(name = "SKILL_ID")
	private Skill skill;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="CREATED_USER_ID")
	private User user;

	//bi-directional many-to-one association to TTestQuestion
	@OneToMany(mappedBy="tQuestion")
	private List<TTestQuestion> tTestQuestions;

	public TQuestion() {
	}

	public int getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean getIsMultipleChoice() {
		return this.isMultipleChoice;
	}

	public void setIsMultipleChoice(boolean isMultipleChoice) {
		this.isMultipleChoice = isMultipleChoice;
	}

	public String getStem() {
		return this.stem;
	}

	public void setStem(String stem) {
		this.stem = stem;
	}

	public List<TOption> getTOptions() {
		return this.tOptions;
	}

	public void setTOptions(List<TOption> tOptions) {
		this.tOptions = tOptions;
	}

	public TOption addTOption(TOption tOptions) {
		getTOptions().add(tOptions);
		tOptions.setTQuestion(this);

		return tOptions;
	}

	public TOption removeTOption(TOption tOptions) {
		getTOptions().remove(tOptions);
		tOptions.setTQuestion(null);

		return tOptions;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<TTestQuestion> getTTestQuestions() {
		return tTestQuestions;
	}

	public void setTTestQuestions(List<TTestQuestion> tTestQuestions) {
		this.tTestQuestions = tTestQuestions;
	}

	public TTestQuestion addTTestQuestion(TTestQuestion tTestQuestion) {
		getTTestQuestions().add(tTestQuestion);
		tTestQuestion.setTQuestion(this);

		return tTestQuestion;
	}

	public TTestQuestion removeTTestQuestion(TTestQuestion tTestQuestion) {
		getTTestQuestions().remove(tTestQuestion);
		tTestQuestion.setTQuestion(null);

		return tTestQuestion;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

}
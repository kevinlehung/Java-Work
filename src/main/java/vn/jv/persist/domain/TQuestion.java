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
	private byte isMultipleChoice;

	private String stem;

	//bi-directional many-to-one association to TOption
	@OneToMany(mappedBy="tQuestion")
	private List<TOption> tOptions;

	//bi-directional many-to-one association to WorkCategory
	@ManyToOne
	@JoinColumn(name="WORK_CATEGORY_ID")
	private WorkCategory workCategory;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="CREATED_USER_ID")
	private User user;

	//bi-directional many-to-one association to TTestQuestion
	@OneToMany(mappedBy="tQuestion")
	private List<TTestQuestion> TTestQuestions;

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

	public byte getIsMultipleChoice() {
		return this.isMultipleChoice;
	}

	public void setIsMultipleChoice(byte isMultipleChoice) {
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

	public void setTOptions(List<TOption> TOptions) {
		this.tOptions = TOptions;
	}

	public TOption addTOption(TOption TOption) {
		getTOptions().add(TOption);
		TOption.setTQuestion(this);

		return TOption;
	}

	public TOption removeTOption(TOption TOption) {
		getTOptions().remove(TOption);
		TOption.setTQuestion(null);

		return TOption;
	}

	public WorkCategory getWorkCategory() {
		return this.workCategory;
	}

	public void setWorkCategory(WorkCategory workCategory) {
		this.workCategory = workCategory;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<TTestQuestion> getTTestQuestions() {
		return this.TTestQuestions;
	}

	public void setTTestQuestions(List<TTestQuestion> TTestQuestions) {
		this.TTestQuestions = TTestQuestions;
	}

	public TTestQuestion addTTestQuestion(TTestQuestion TTestQuestion) {
		getTTestQuestions().add(TTestQuestion);
		TTestQuestion.setTQuestion(this);

		return TTestQuestion;
	}

	public TTestQuestion removeTTestQuestion(TTestQuestion TTestQuestion) {
		getTTestQuestions().remove(TTestQuestion);
		TTestQuestion.setTQuestion(null);

		return TTestQuestion;
	}

}
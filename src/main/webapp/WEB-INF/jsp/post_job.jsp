<%@ include file="/WEB-INF/jsp/include/taglibs_include.jsp" %>
<!DOCTYPE html>
<html>
<title>Post Java Job - Compose</title>
<body class='contrast-red '>
	<div class='row-fluid'>
		<div class='span12'>
			<div class='page-header'>
				<h1 class='pull-left'>
					<i class='icon-edit'></i> <span>Post Your Job</span>
				</h1>
				<div class='pull-right'>
					<ul class='breadcrumb'>
						<li><a href="index.html"><i class='icon-bar-chart'></i> </a>
						</li>
						<li class='separator'><i class='icon-angle-right'></i></li>
						<li>Java Work</li>
						<li class='separator'><i class='icon-angle-right'></i></li>
						<li class='active'>Post Your Job</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class='row-fluid'>
		<div class='span12 box'>
			<div class='box-content box-padding'>
				<div class='fuelux'>
					<div class='wizard'>
						<ul class='steps'>
							<li class='active' data-target='#step1'><span class='step'>Describe</span>
							</li>
							<li data-target='#step2'><span class='step'>Preview</span></li>
							<li data-target='#step3'><span class='step'>Done</span></li>
						</ul>
						<div class='actions'>
							<button class='btn btn-mini btn-prev'>
								<i class='icon-arrow-left'></i>Prev
							</button>
							<button class='btn btn-mini btn-success btn-next'
								data-last='Finish'>
								Next <i class='icon-arrow-right'></i>
							</button>
						</div>
					</div>
					<div class='step-content'>
						<hr class='hr-normal' />
						<form:form accept-charset="UTF-8" action="${contextPath}/u/post_job/preview.jv" class="form form-striped"
							method="post" style="margin-bottom: 0;" commandName="postJobForm">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<div style="margin: 0; padding: 0; display: inline">
							<input name="utf8" type="hidden" value="&#x2713;" /><input
								name="authenticity_token" type="hidden"
								value="CFC7d00LWKQsSahRqsfD+e/mHLqbaVIXBvlBGe/KP+I=" />
						</div>
						<div class='step-pane active' id='step1'>
							<div class='control-group'>
								<label class='control-label' for='inputText'>Name your job</label>
								<div class='controls'>
									<form:input class='input-block-level' id='inputText'
										placeholder='Text field' path="title"/>
								</div>
							</div>
							<div class='control-group'>
								<label class='control-label' for='inputText'>Briefly
									describe the skills required</label>
								<div class='controls'>
									<form:textarea class='input-block-level' id='inputTextArea'
										placeholder='Textarea' rows='6' path="customRequiredSkill"/>
								</div>
							</div>
							<div class='control-group'>
								<label class='control-label' for='inputText'>Job
									description</label>
								<div class='controls'>
									<form:textarea class='input-block-level' id='inputTextArea'
										placeholder='Textarea' rows='12' path="description"/>
								</div>
							</div>
							<div class="control-group">
								<label for="inputSelect" class="control-label">Select
									the category of work</label>
								<div class="controls">
									<form:select id="inputSelect" path="workCategoryId" items="${workCategories}" itemLabel="domain" itemValue="workCategoryId">
									</form:select>
								</div>
							</div>
							<div class="control-group">
								<label for="inputSelectMulti" class="control-label">Request
									specific skills</label>
								<div class="controls">
									<form:select multiple="multiple" id="inputSelectMulti"  path="requiredSkillIds" items="${skills}" itemLabel="name" itemValue="skillId">
									</form:select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Salary</label>
								<div class="controls controls-row">
									<input type="text" class="span2" placeholder="From (US$)">
									<input type="text" class="span2" placeholder="To (US$)">
									<select id="inputSelect" class="span2">
										<option>Fixed Price</option>
										<option>Per Month</option>
										<option>Per Hour</option>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class='control-label' for='inputText'>Location</label>
								<div class="controls">
									<select id="inputSelect" class="span2">
										<option>Country</option>
										<option>Singapore</option>
										<option>Vietnam</option>
									</select> <select id="inputSelect" class="span2">
										<option>City</option>
										<option>Singapore</option>
										<option>Vietnam</option>
									</select>
								</div>
							</div>
							<div class='control-group'>
								<label class='control-label' for='inputText'>Privacy and
									Other Options</label>
								<div class='controls'>
									<textarea class='input-block-level' id='inputTextArea'
										placeholder='Textarea' rows='3'></textarea>
								</div>
							</div>
							<hr class="hr-normal">

							<div class="text-right">
								<a href="/" class="btn btn-danger btn-large">
									<i class="icon-remove"></i> Cancel
								</a>
								<button type="submit" class="btn btn-primary btn-large">
									<i class="icon-check"></i> Preview
								</button>
							</div>
						</div>
						<div class='step-pane' id='step2'>
							<div class='control-group'>
								<label class='control-label' for='inputPassword'>Password
									field</label>
								<div class='controls'>
									<input class='input-block-level' id='inputPassword'
										placeholder='Password field' type='password' />
								</div>
							</div>
						</div>
						<div class='step-pane' id='step3'>
							<div class='control-group'>
								<label class='control-label' for='inputTextArea'>Textarea</label>
								<div class='controls'>
									<textarea class='input-block-level' id='inputTextArea'
										placeholder='Textarea' rows='3'></textarea>
								</div>
							</div>
						</div>
						<div class='step-pane' id='step4'>
							<div class='control-group'>
								<div class='controls'>
									<label class='checkbox inline'> <input
										id='inlineCheckbox1' type='checkbox' value='option1' />
										Inline 1
									</label> <label class='checkbox inline'> <input
										id='inlineCheckbox2' type='checkbox' value='option2' />
										Inline 2
									</label> <label class='checkbox inline'> <input
										id='inlineCheckbox3' type='checkbox' value='option3' />
										Inline 3
									</label>
								</div>
							</div>
						</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

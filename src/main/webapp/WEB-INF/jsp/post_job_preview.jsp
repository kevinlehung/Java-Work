<!DOCTYPE html>
<html>
<title>Post Java Job - Preview</title>
<body class='contrast-red '>
	<div class='row-fluid'>
		<div class='span12'>
			<div class='page-header'>
				<h1 class='pull-left'>
					<i class='icon-edit'></i> <span>Preview Your Post</span>
				</h1>
				<div class='pull-right'>
					<ul class='breadcrumb'>
						<li><a href="index.html"><i class='icon-bar-chart'></i> </a>
						</li>
						<li class='separator'><i class='icon-angle-right'></i></li>
						<li>Java Work</li>
						<li class='separator'><i class='icon-angle-right'></i></li>
						<li class='active'>Preview Your Post</li>
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
							<li data-target='#step1'><span class='step'>Describe</span>
							</li>
							<li class='active' data-target='#step2'><span class='step'>Preview</span>
							</li>
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
					<div class="step-content">
						<div class='box'>
							<div class="box-header">
								<div class="title">
									<h2>${postJobForm.title}</h2>
								</div>
								<div class="actions">
									<a class="btn box-collapse btn-mini btn-link" href="#"><i></i>
									</a>
								</div>
							</div>
							<div class="box-content">
								<div class="row-fluid">
									<i class="icon-time"></i> Posted: Dec 16, 2013 <br /> <i
										class="icon-group"></i> Company: Global <br /> <i
										class="icon-location-arrow"></i> Location: HCM<br /> <i
										class="icon-adjust"></i> Job: Fulltime <br /> <i
										class="icon-money"></i> Salary: 1000 US$/Month <br /> <i
										class="icon-smile"></i> Applied: 6
								</div>
							</div>
						</div>
						<div class='box'>
							<div class="box-header">
								<div class="title">Job Description</div>
								<div class="actions">
									<a class="btn box-collapse btn-mini btn-link" href="#"><i></i>
									</a>
								</div>
							</div>
							<div class="box-content">
								<div class="row-fluid">${postJobForm.description}</div>
							</div>
						</div>
						<div class='box'>
							<div class="box-header">
								<div class="title">Desired skills</div>
								<div class="actions">
									<a class="btn box-collapse btn-mini btn-link" href="#"><i></i>
									</a>
								</div>
							</div>
							<div class="box-content">
								<div class="row-fluid">
									<a href="javascript:;">Java</a>, <a href="javascript:;">PHP</a>,
									<a href="javascript:;">Html/Css</a>
								</div>
							</div>
							<hr class="hr-normal">

							<div class="text-right">
								<a href="/" class="btn btn-danger btn-large">
									<i class="icon-remove"></i> Cancel
								</a>
								<a href="post_job_done.jsp" class="btn btn-primary btn-large">
									<i class="icon-check"></i> Post Job
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

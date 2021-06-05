package kodlamaio.hrms.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Resume;

@RestController
@RequestMapping("/api/resumes")
public class ResumesController {

	private ResumeService resumeService;

	@Autowired
	public ResumesController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}

	@GetMapping("/getByResumeIdForJobSeekerId")
	public DataResult<List<Resume>> getByResumeIdForJobSeekerId(int jobSeekerId) {
		return this.resumeService.getByResumeIdForJobSeekerId(jobSeekerId);
	}

	@PostMapping("/add")
	public Result add(@RequestBody Resume resume) {
		return this.resumeService.add(resume);
	}

	@PutMapping("/uploadImage")
	public Result saveImage(@RequestBody MultipartFile file, @RequestParam int resumeId) {
		return this.resumeService.saveImage(file, resumeId);

	}

	@GetMapping("/getAll")
	public DataResult<List<Resume>> getAll() {
		return this.resumeService.getAll();
	}
}

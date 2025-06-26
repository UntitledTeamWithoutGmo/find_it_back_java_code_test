package CodeTest.demo.controllers;

import CodeTest.demo.models.Answer;
import CodeTest.demo.models.Code;
import CodeTest.demo.services.CodeService;
import org.codehaus.commons.compiler.CompileException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/code")
public class CodeController {

    @Autowired
    private CodeService codeService;

    @PostMapping("/java")
    private ResponseEntity<Answer> testCodeJava(@RequestBody Code code) throws CompileException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return codeService.responseCode(code.getCode());
    }
}

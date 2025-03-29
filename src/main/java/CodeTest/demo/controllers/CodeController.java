package CodeTest.demo.controllers;

import CodeTest.demo.models.Code;
import CodeTest.demo.services.CodeService;
import org.codehaus.commons.compiler.CompileException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("api/code")
public class CodeController {

    @Autowired
    private CodeService codeService;

    @PostMapping("/java")
    private ResponseEntity<String> testCodeJava(@RequestBody Code code) throws CompileException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return ResponseEntity.ok().body(codeService.responseCode(code.getCode()));
    }
}

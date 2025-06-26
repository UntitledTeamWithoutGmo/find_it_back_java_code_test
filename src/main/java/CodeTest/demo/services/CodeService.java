package CodeTest.demo.services;

import CodeTest.demo.models.Answer;
import org.codehaus.commons.compiler.CompileException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

@Service
public interface CodeService {
    public ResponseEntity<Answer> responseCode(String code) throws CompileException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}

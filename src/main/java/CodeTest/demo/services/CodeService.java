package CodeTest.demo.services;

import org.codehaus.commons.compiler.CompileException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

@Service
public interface CodeService {
    public ResponseEntity<String> responseCode(String code) throws CompileException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}

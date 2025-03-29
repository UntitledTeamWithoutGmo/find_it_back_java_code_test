package CodeTest.demo.services;

import org.codehaus.commons.compiler.CompileException;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

@Service
public interface CodeService {
    public String responseCode(String code) throws CompileException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}

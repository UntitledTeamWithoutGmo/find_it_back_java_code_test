package CodeTest.demo.services;

import CodeTest.demo.kafka.KafkaProducer;
import org.codehaus.commons.compiler.CompileException;
import org.codehaus.janino.SimpleCompiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Service
public class CodeServiceImpl implements CodeService{

    @Autowired
    private KafkaProducer kafkaProducer;
    @Override
    public ResponseEntity<String> responseCode(String code) throws CompileException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        SimpleCompiler simpleCompiler = new SimpleCompiler();

        String responseEnd = "";

        simpleCompiler.cook(code);
        Class<?> testClass = simpleCompiler.getClassLoader().loadClass("TestClass");

        Method method = testClass.getMethod("calculate",int.class,int.class);
        int response = (int)method.invoke(null,5,3);

        if (response==8){
            kafkaProducer.sendMessage("pidor");
            return ResponseEntity.status(200).body(""+response);
        }






        return ResponseEntity.status(300).body("Bad");
    }
}

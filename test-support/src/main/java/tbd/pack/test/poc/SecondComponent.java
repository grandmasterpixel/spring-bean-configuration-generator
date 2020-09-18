package tbd.pack.test.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecondComponent {
    @Autowired
    private FirstComponent firstComponent;
}

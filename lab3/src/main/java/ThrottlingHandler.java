import exceptions.ThrottlingException;
import faults.ThrottlingFault;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.*;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@Provider
public class ThrottlingHandler implements WriterInterceptor, ReaderInterceptor {
    private static AtomicInteger counter = new AtomicInteger(0);
    private final int MAX_REQUESTS = 3;
    private static final Object lock = new Object();

    @Override
    public Object aroundReadFrom(ReaderInterceptorContext context)
            throws IOException, WebApplicationException {

        int currentCount = counter.get();
        if (currentCount >= MAX_REQUESTS) {
            ThrottlingFault tf = ThrottlingFault.defaultInstance();
            throw new ThrottlingException("The maximum requests number has been reached.", tf);
        }

        synchronized (lock) {
            currentCount = counter.get();
            if (currentCount >= MAX_REQUESTS) {
                ThrottlingFault tf = ThrottlingFault.defaultInstance();
                throw new ThrottlingException("The maximum requests number has been reached.", tf);
            }
            counter.incrementAndGet();
        }

        try {
            return context.proceed();
        }
        finally {
            counter.decrementAndGet();
        }
    }

    @Override
    public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
        context.proceed();
    }
}
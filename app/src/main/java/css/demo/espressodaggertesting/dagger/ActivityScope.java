package css.demo.espressodaggertesting.dagger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Dagger Scope for {@link MainActivityComponent}
 */

@Retention(RetentionPolicy.RUNTIME)
@Scope
public @interface ActivityScope {

}

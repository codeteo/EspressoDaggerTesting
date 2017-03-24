package css.demo.espressodaggertesting;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.net.UnknownHostException;

import css.demo.espressodaggertesting.data.User;
import css.demo.espressodaggertesting.rules.RxSchedulersOverrideRule;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;

import static css.demo.espressodaggertesting.network.ErrorCode.CODE_401_UNAUTHORIZED;
import static css.demo.espressodaggertesting.network.ErrorCode.CODE_404_PAGE_NOT_FOUND;
import static css.demo.espressodaggertesting.network.ErrorCode.CODE_UNKNOWNHOST_EXCEPTION;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Unit test {@link MainActivityPresenter}
 */
@RunWith(MockitoJUnitRunner.class)
public class MainActivityPresenterTest {

    @Mock
    MainMVP.View view;

    @Mock
    GithubService githubService;

    @Rule
    public final RxSchedulersOverrideRule mOverrideSchedulersRule = new RxSchedulersOverrideRule();

    private MainActivityPresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        presenter = new MainActivityPresenter(view, githubService);
    }

    @Test
    public void loadData_shouldShowData() throws Exception {
        // given
        User user = user();
        when(githubService.getRepos()).thenReturn(Observable.just(user));

        // when
        presenter.loadData();

        // then
        verify(view).showData(user);
        verify(view, never()).showError(anyString());
    }

    @Test
    public void loadData_404ResponseCode_shouldShowError() throws Exception {
        // given
        when(githubService.getRepos())
                .thenReturn(Observable.<User>error(new HttpException(response404())));

        // when
        presenter.loadData();

        // then
        verify(view).showError(CODE_404_PAGE_NOT_FOUND);
        verify(view, never()).showData(user());
    }

    @Test
    public void loadData_401ResponseCode_shouldShowError() throws Exception {
        // given
        when(githubService.getRepos())
                .thenReturn(Observable.<User>error(new HttpException(response401())));

        // when
        presenter.loadData();

        // then
        verify(view).showError(CODE_401_UNAUTHORIZED);
        verify(view, never()).showData(user());
    }

    @Test
    public void loadData_unknownHost_shouldShowError() throws Exception {
        // given
        when(githubService.getRepos())
                .thenReturn(Observable.<User>error(new UnknownHostException()));

        // when
        presenter.loadData();

        // then
        verify(view).showError(CODE_UNKNOWNHOST_EXCEPTION);
        verify(view, never()).showData(user());
    }

    private User user() {
        return new User("login", "avatar_url");
    }

    private Response<User> response404() {
        return Response.error(404, ResponseBody.create(null, new byte[0]));
    }

    private Response<User> response401() {
        return Response.error(401, ResponseBody.create(null, new byte[0]));
    }

}
// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package io.github.erikcaffrey.kata_dagger2_mariokart.di;

import dagger.internal.Preconditions;
import io.github.erikcaffrey.kata_dagger2_mariokart.data.Repository;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase.GetCharacters;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.activity.CharacterActivity;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.activity.CharacterActivity_MembersInjector;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.activity.CharacterDetailActivity;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.activity.CharacterDetailActivity_MembersInjector;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.presenter.CharactersPresenter;

public final class DaggerCharactersComponent implements CharactersComponent {
  private CharactersModule charactersModule;

  private DaggerCharactersComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static CharactersComponent create() {
    return new Builder().build();
  }

  private Repository getRepository() {
    return Preconditions.checkNotNull(
        charactersModule.provideCharacterRepository(
            Preconditions.checkNotNull(
                charactersModule.provideCharacterFakeDataSource(),
                "Cannot return null from a non-@Nullable @Provides method")),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  private GetCharacters getGetCharacters() {
    return new GetCharacters(getRepository());
  }

  private CharactersPresenter getCharactersPresenter() {
    return new CharactersPresenter(getGetCharacters());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.charactersModule = builder.charactersModule;
  }

  @Override
  public void inject(CharacterActivity characterActivity) {
    injectCharacterActivity(characterActivity);
  }

  @Override
  public void inject(CharacterDetailActivity characterDetailActivity) {
    injectCharacterDetailActivity(characterDetailActivity);
  }

  private CharacterActivity injectCharacterActivity(CharacterActivity instance) {
    CharacterActivity_MembersInjector.injectPresenter(instance, getCharactersPresenter());
    return instance;
  }

  private CharacterDetailActivity injectCharacterDetailActivity(CharacterDetailActivity instance) {
    CharacterDetailActivity_MembersInjector.injectPresenter(instance, getCharactersPresenter());
    return instance;
  }

  public static final class Builder {
    private CharactersModule charactersModule;

    private Builder() {}

    public CharactersComponent build() {
      if (charactersModule == null) {
        this.charactersModule = new CharactersModule();
      }
      return new DaggerCharactersComponent(this);
    }

    public Builder charactersModule(CharactersModule charactersModule) {
      this.charactersModule = Preconditions.checkNotNull(charactersModule);
      return this;
    }
  }
}

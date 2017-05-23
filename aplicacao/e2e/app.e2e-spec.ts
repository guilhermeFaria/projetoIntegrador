import { AplicacaoPage } from './app.po';

describe('aplicacao App', () => {
  let page: AplicacaoPage;

  beforeEach(() => {
    page = new AplicacaoPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});

import { HrFrontendPage } from './app.po';

describe('hr-frontend App', function() {
  let page: HrFrontendPage;

  beforeEach(() => {
    page = new HrFrontendPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});

export const oktaConfig = {
    clientId: '0oae41ymnpweBe8Hz5d7',
    issuer: 'https://dev-97709950.okta.com/oauth2/default',
    redirectUri: 'http://localhost:3000/login/callback',
    scopes: ['openid', 'profile', 'email'],
    pkce: true,
    disableHttpsCheck: true
}
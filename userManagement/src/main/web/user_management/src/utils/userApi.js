const ENDPOINT = 'https://localhost:8443/userManagement/getUser';

export function getUsers() {
    return fetch(ENDPOINT).then(res => res.json()).catch(err => console.log(err))
}
const GET_ENDPOINT = 'https://localhost:8443/userManagement/getUser';
const POST_ENDPOINT = 'https://localhost:8443/userManagement/addUser';

export function getUsers() {
    return fetch(GET_ENDPOINT).then(res => res.json()).catch(err => console.log(err))
}

export async function addNewUser(newUser) {
    return await fetch(POST_ENDPOINT, {
        headers: {
            'Content-Type': 'application/json'
        },
        method: 'POST',
        body: JSON.stringify(newUser)
    });
}
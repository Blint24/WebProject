import axios from "axios"

export class VenueController {
    static async createVenue(venueDTO) {
        const respone = await axios.post(`http://localhost:8080/rqimmp/venues/createVenue`, venueDTO)
        return respone.data
    }

    static async getAll() {
        const respons = await axios.get('http://localhost:8080/rqimmp/venues/getAll')
        return respons.data
    }

    static async updateVenue(venueDTO) {
        const respons = await axios.patch('http://localhost:8080/rqimmp/venues/updateVenue', venueDTO)
        return respons.data
    }

    static async deleteVenue(venueDTO) {
        const respons = await axios.delete('http://localhost:8080/rqimmp/venues/deleteVenue' , {data : venueDTO})
        return respons.data
    }
}
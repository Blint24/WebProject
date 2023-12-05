import axios from "axios"

export class PerformerController {
    static async createPerformer(performerDTO){
        const respons = await axios.post('http://localhost:8080/rqimmp/performers/createPerformer', performerDTO)
        return respons.data
    }

    static async getAll() {
        const respons = await axios.get('http://localhost:8080/rqimmp/performers/getAll')
        return respons.data
    }

    static async updatePerformer(performerDTO) {
        const respons = await axios.patch('http://localhost:8080/rqimmp/performers/updatePerformer', performerDTO)
        return respons.data
    }

    static async deletePerformer(performerDTO) {
        const respons = await axios.delete('http://localhost:8080/rqimmp/performers/deletePerformer' , {data : performerDTO})
        return respons.data
    }
}
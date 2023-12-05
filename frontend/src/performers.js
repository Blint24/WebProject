import './CRUDTable.css'
import CRUDTable,
{
  Fields,
  Field,
  CreateForm,
  UpdateForm,
  DeleteForm,
} from 'react-crud-table';
import "./index.css";
import { Link } from 'react-router-dom';
import { PerformerController } from './performerController';
import React, { useState } from 'react';

const styles = {
    container: { margin: "auto", width: "fit-content" }
  };


const DescriptionRenderer = ({ field }) => <textarea {...field} />;

export function Performers() {

    const [deleteError, setDeleteError] = useState(null);

    const handleDeletePerformer = async (id) => {
        try {
            await PerformerController.deletePerformer(id);
        } catch (error) {
            console.error('Delete performer error:', error);
            setDeleteError("Failed to delete performer. There may be existing venues with the performer's Id ");
            alert("First you have to delete the venues with the performer's Id")
        }
    };

    return (
        <div style={styles.container}> 
            <Link to='/venues'>Venues</Link>
            <CRUDTable caption='Performers' fetchItems={() => PerformerController.getAll()}>
                <Fields>
                    <Field name='performerId' label='Id' hideInCreateForm readOnly/>
                    <Field name='firstName' label='First Name' placeholder='F_Name' />
                    <Field name='lastName' label='Last Name' placeholder='L_Name' />
                    <Field name='nickname' label='Nickname' placeholder='Nickname' />
                    <Field name='password' label='Password' placeholder='Password' />
                </Fields>
                <CreateForm 
                    title='Performer Creator' message='Add a new Performer' 
                    trigger='Add Performer' onSubmit={PerformerController.createPerformer} submitText='Add'/>    
                <UpdateForm 
                    title='Update Performer' message='Update the Performer' 
                    trigger='Update' onSubmit={PerformerController.updatePerformer} submitText='Update'/>    
                <DeleteForm 
                    title='Delete Performer' message='Delete the Performer' 
                    trigger='Delete' onSubmit={handleDeletePerformer} submitText='Delete'/>
            </CRUDTable>
        </div>
    )


}
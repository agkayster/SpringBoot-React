import React, { useState } from 'react';
import axios from 'axios';
import Image from 'next/image';
// import profPic from '../public/MI_abaga_img.jpeg';
import backgroundPic from '../public/profile.jpeg';

const Students = ({ students, error }) => {
	const [getStudents, setgetStudents] = useState(students);
	console.log('get Students =>', getStudents);

	if (error) {
		return <div>An error occured: {error.message}</div>;
	}

	return (
		<>
			{getStudents.map(({ name, email, dob, age }) => (
				<div
					className='w-6/12 lg:max-w-full lg:flex mt-3 pl-6'
					key={name}>
					<div
						className='h-48 lg:h-96 lg:w-60 flex-none bg-cover rounded-t lg:rounded-t-none lg:rounded-l lg:border-l lg:border-t lg:border-gray-400 text-center overflow-hidden backgroundImage'
						// style={{
						// 	backgroundImage: 'url(/profile.jpeg)',
						// }}
						title='Student passport'></div>
					<div className='border-r border-b border-l border-gray-400 lg:border-l-0 lg:border-t lg:border-gray-400 bg-white rounded-b lg:rounded-b-none lg:rounded-r p-4 flex flex-col justify-between leading-normal'>
						<div className='mb-8'>
							<p className='text-sm text-gray-600 flex items-center'>
								<svg
									className='fill-current text-gray-500 w-3 h-3 mr-2'
									xmlns='http://www.w3.org/2000/svg'
									viewBox='0 0 20 20'>
									<path d='M4 8V6a6 6 0 1 1 12 0v2h1a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-8c0-1.1.9-2 2-2h1zm5 6.73V17h2v-2.27a2 2 0 1 0-2 0zM7 6v2h6V6a3 3 0 0 0-6 0z' />
								</svg>
								Students only
							</p>
							<div className='text-gray-900 font-bold text-xl mb-2 mt-3'>
								Name: {name}
							</div>
							<p className='text-gray-700 text-base'>
								Email: {email}
							</p>
							<p className='text-gray-700 text-base mt-3'>
								Date Of Birth: {dob}
							</p>
							<p className='text-gray-700 text-base mt-3'>
								{' '}
								Age: {age}
							</p>
						</div>
						<div className='flex items-center'>
							<Image
								className='w-10 h-10 rounded-full mr-4'
								src={backgroundPic}
								alt='Avatar of Jonathan Reinink'
								width={50}
								height={50}
							/>
							<div className='text-sm'>
								<p className='text-gray-900 leading-none'>
									{name}
								</p>
								<p className='text-gray-600'>Aug 18</p>
							</div>
						</div>
					</div>
				</div>
			))}
		</>
	);
};

export const getServerSideProps = async (ctx) => {
	try {
		const res = await axios.get('http://localhost:8080/api/v1/student/');
		const students = res.data;
		return {
			props: {
				students,
			},
		};
	} catch (error) {
		return error;
	}
};

export default Students;
